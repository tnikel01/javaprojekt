const btn12 = document.getElementById('btn12');
const btn21 = document.getElementById('btn21');
const btnadd = document.getElementById('btn21');
const Fieldload = document.getElementById('load');
const Useranswer = document.getElementById('Useranswer');
const messageContainer = document.getElementById('learndiv');

btn12.addEventListener('click', function() {
  const newMessage = document.createElement('p');
  btn12.style.opacity = "0";
  btn21.style.opacity = "0";
  document.getElementById("learndiv").style.opacity = "1";
  newMessage.textContent = 'English-Spanish';

  messageContainer.appendChild(newMessage);
});

btn12.addEventListener('click', function() {
  const newMessage = document.createElement('p');
  btn12.style.opacity = "0";
  btn21.style.opacity = "0";
  document.getElementById("learndiv").style.opacity = "1";
  newMessage.textContent = 'Spanish-English';

  messageContainer.appendChild(newMessage);
});

btnadd.addEventListener('click', function(){
  
});

Fieldload.addEventListener("keydown", function(event) {
  if (event.key === "Enter" && this.value.trim() !== "") {
      event.preventDefault();
      console.log("Submitted:", inputValue);
  }
});

Useranswer.addEventListener("keydown", function(event) {
  if (event.key === "Enter" && this.value.trim() !== "") {
      event.preventDefault(); 
      console.log("Answer:", inputValue);
  }
});