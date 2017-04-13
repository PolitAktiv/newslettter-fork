function confirmar(label, url) {
               
        if (confirm(label)) {
                location.href=url;
        } else {
                self.focus();
        }
}