// Load Vue.js from CDN
const vueScript = document.createElement("script");
vueScript.src = "https://unpkg.com/vue@3/dist/vue.global.js";
document.head.appendChild(vueScript);

// Load Axios from CDN
const axiosScript = document.createElement("script");
axiosScript.src = "https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js";
document.head.appendChild(axiosScript);

// Wait for both Vue.js and Axios to load
vueScript.onload = () => {
  axiosScript.onload = () => {
    // Axios 설정 및 인터셉터 설정
    axios.defaults.baseURL = "http://localhost:8080/";

    axios.interceptors.request.use(
      (config) => {
        console.log("보낸 요청:", config);
        return config;
      },
      (error) => {
        console.error("요청 오류:", error);
        return Promise.reject(error);
      }
    );

    axios.interceptors.response.use(
      (response) => {
        console.log("받은 응답:", response);
        return response;
      },
      (error) => {
        console.error("응답 오류:", error);
        return Promise.reject(error);
      }
    );

    // Vue 애플리케이션 초기화
    if (typeof window.initializeVueApp === "function") {
      window.initializeVueApp();
    }
  };
};
