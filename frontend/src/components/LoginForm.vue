<script setup>
import { ref } from 'vue'

const emit = defineEmits(['loginSuccess'])

const API_URL = 'http://localhost:8080/api'

const email = ref('')
const password = ref('')
const error = ref('')

async function login() {
  error.value = ''

  const response = await fetch(`${API_URL}/auth/login`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      email: email.value,
      password: password.value
    })
  })

  if (response.ok) {
    emit('loginSuccess')
  } else {
    error.value = 'Invalid credentials'
  }
}
</script>

<template>
  <div>
    <input v-model="email" placeholder="Email" />
    <input v-model="password" type="password" placeholder="Password" />
    <button @click="login">Login</button>

    <p v-if="error" style="color:red">{{ error }}</p>
  </div>
</template>