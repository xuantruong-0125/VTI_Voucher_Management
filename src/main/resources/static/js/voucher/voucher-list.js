async function deleteVoucher(id) {

    const confirmDelete = confirm(
        "Are you sure to delete this voucher?"
    );

    if (!confirmDelete) {
        return;
    }

    const response = await fetch(
        `/api/vouchers/${id}`,
        {
            method: "DELETE"
        }
    );

    const result = await response.json();

    alert(result.message);

    if (result.success) {
        location.reload();
    }
}