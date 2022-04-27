import axios from "axios";

//TODO error catch 로직 추가하기
const customAxios = axios.create({
  baseURL : `${process.env.BASE_URL}`,
})

const post = async (url, data) => {
    const response = await customAxios.post(url, data);
    return response;
}

const get = async (url, params) => {
  const response = await customAxios.get(url, {params: params});
  return response;
}

export default {
  post,
  get
}

