<script setup>
import { ref, onMounted } from 'vue'
import LoginForm from './components/LoginForm.vue'
import EventList from './components/EventList.vue'
import CreateEvent from './components/CreateEvent.vue'

const API_URL = 'http://localhost:8080/api'

const events = ref([])
const isAdmin = ref(false)
const selectedEventId = ref(null)

async function loadEvents() {
  const response = await fetch(`${API_URL}/events`)
  events.value = await response.json()
}

function handleLogin() {
  isAdmin.value = true
}

function handleEventCreated() {
  loadEvents()
}

function handleSelectEvent(eventId) {
  selectedEventId.value = eventId
}

function handleRegistered() {
  selectedEventId.value = null
}

onMounted(loadEvents)
</script>

<template>
  <div class="app">
    <h1>Event Registration</h1>

    <!-- Login -->
    <LoginForm v-if="!isAdmin" @loginSuccess="handleLogin" />

    <p v-if="isAdmin">Admin logged in</p>

    <!-- Create Event -->
    <CreateEvent v-if="isAdmin" @eventCreated="handleEventCreated" />

    <!-- Events -->
    <EventList
        :events="events"
        :selectedEventId="selectedEventId"
        @selectEvent="handleSelectEvent"
        @registered="handleRegistered"
    />
  </div>
</template>

<style>
.app {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  font-family: Arial;
}
</style>
