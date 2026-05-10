<script setup>
import { ref } from 'vue'

const props = defineProps({
  eventId: Number
})

const emit = defineEmits(['registered'])

const API_URL = 'http://localhost:8080/api'

const firstName = ref('')
const lastName = ref('')
const personalCode = ref('')
const message = ref('')

async function register() {
  message.value = ''

  const response = await fetch(`${API_URL}/events/${props.eventId}/register`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      firstName: firstName.value,
      lastName: lastName.value,
      personalCode: personalCode.value
    })
  })

  if (response.ok) {
    message.value = 'Registered successfully'

    firstName.value = ''
    lastName.value = ''
    personalCode.value = ''

    emit('registered')
  } else {
    message.value = 'Registration failed'
  }
}
</script>

<template>
  <div class="register-form">
    <input v-model="firstName" placeholder="First name" />
    <input v-model="lastName" placeholder="Last name" />
    <input v-model="personalCode" placeholder="Personal code" />

    <button @click="register">Submit</button>

    <p v-if="message">{{ message }}</p>
  </div>
</template>

<style scoped>
.register-form {
  margin-top: 10px;
  display: flex;
  gap: 8px;
  flex-wrap: wrap;
}

input {
  padding: 6px;
}

button {
  padding: 6px 10px;
}
</style>