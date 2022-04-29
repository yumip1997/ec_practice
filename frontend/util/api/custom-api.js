import axios from "axios";
import {convertURL} from "./url-maker";

//TODO error catch 로직 추가하기
const customAxios = axios.create({
  baseURL : `${process.env.BASE_URL}`,
})

const post = async (url, data) => {
  const response = await axios.post(convertURL(url), data);
  return response;
}

const get = async (url, params) => {
  const response = await axios.get(convertURL(url), {params: params});
  return response;
}

export default {
  post,
  get
}

