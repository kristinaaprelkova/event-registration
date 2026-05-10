<script setup>
import RegisterForm from './RegisterForm.vue'

defineProps({
  events: {
    type: Array,
    required: true
  },
  selectedEventId: {
    type: Number,
    default: null
  }
})

const emit = defineEmits(['selectEvent', 'registered'])
</script>

<template>
  <section class="card">
    <h2>Events</h2>

    <p v-if="events.length === 0">No events available.</p>

    <div v-for="event in events" :key="event.id" class="event">
      <h3>{{ event.title }}</h3>
      <p>Time: {{ event.eventTime }}</p>
      <p>Max participants: {{ event.maxParticipants }}</p>

      <button @click="emit('selectEvent', event.id)">
        Register
      </button>

      <RegisterForm
          v-if="selectedEventId === event.id"
          :event-id="event.id"
          @registered="emit('registered')"
      />
    </div>
  </section>
</template>

<style scoped>
.card {
  border: 1px solid #ddd;
  padding: 16px;
  margin-bottom: 20px;
  border-radius: 8px;
}

.event {
  border-top: 1px solid #eee;
  padding: 12px 0;
}

button {
  padding: 8px 12px;
  cursor: pointer;
}
</style>