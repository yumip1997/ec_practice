const convertURL = (url) =>  getBaseURL() + url

const getBaseURL = () => `${process.server}` === "true" ? `${process.env.BASE_URL}` : `${process.env.BROWSER_BASE_URL}`

export {
  convertURL
}
