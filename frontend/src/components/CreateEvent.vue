<script setup>
import { ref } from 'vue'

const emit = defineEmits(['eventCreated'])

const API_URL = 'http://localhost:8080/api'

const title = ref('')
const eventTime = ref('')
const maxParticipants = ref(1)
const message = ref('')

async function createEvent() {
  message.value = ''

  const response = await fetch(`${API_URL}/events`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'X-ADMIN': 'true'
    },
    body: JSON.stringify({
      title: title.value,
      eventTime: eventTime.value,
      maxParticipants: maxParticipants.value
    })
  })

  if (response.ok) {
    message.value = 'Event created successfully'

    title.value = ''
    eventTime.value = ''
    maxParticipants.value = 1

    emit('eventCreated')
  } else {
    message.value = 'Could not create event'
  }
}
</script>

<template>
  <section class="card">
    <h2>Create Event</h2>

    <input v-model="title" placeholder="Event title" />

    <input v-model="eventTime" type="datetime-local" />

    <input
        v-model="maxParticipants"
        type="number"
        min="1"
        placeholder="Max participants"
    />

    <button @click="createEvent">Create Event</button>

    <p v-if="message">{{ message }}</p>
  </section>
</template>

<style scoped>
.card {
  border: 1px solid #ddd;
  padding: 16px;
  margin-bottom: 20px;
  border-radius: 8px;
}

input {
  display: block;
  padding: 8px;
  margin: 8px 0;
}

button {
  padding: 8px 12px;
  cursor: pointer;
}
</style>
