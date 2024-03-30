const parserUrl = (name) => {
  const base = "../../src/assets"
  return new URL(base + name, import.meta.url).href
}

export const unknownImg = parserUrl('/images/audio/wave.gif')




