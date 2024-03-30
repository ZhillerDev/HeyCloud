import dayjs from "dayjs"

export const formatDateTime = (time) => {
  return time ? dayjs(new Date(time)).format("YYYY-MM-DD HH:mm:ss") : "N/A"
}
