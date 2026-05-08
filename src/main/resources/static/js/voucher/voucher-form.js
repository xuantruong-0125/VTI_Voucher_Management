document
    .getElementById("voucherForm")
    .addEventListener("submit", async function (e) {

        e.preventDefault();

        const id =
            document.getElementById("voucherId").value;

        const payload = {
            code:
                document.getElementById("code").value,

            discountPercent:
                document.getElementById("discountPercent").value,

            quantity:
                document.getElementById("quantity").value,

            expiredDate:
                document.getElementById("expiredDate").value,

            status:
                document.getElementById("status").value
        };

        const url =
            id
                ? `/api/vouchers/${id}`
                : `/api/vouchers`;

        const method =
            id
                ? "PUT"
                : "POST";

        const response = await fetch(url, {
            method: method,
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(payload)
        });

        const result = await response.json();

        alert(result.message);

        if (result.success) {
            window.location.href = "/vouchers";
        }
    });