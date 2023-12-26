import React, { Component } from 'react'
import MoneyService from '../services/MoneyService'

class ListMoneyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                moneys: []
        }
        this.addMoney = this.addMoney.bind(this);
        this.editMoney = this.editMoney.bind(this);
        this.deleteMoney = this.deleteMoney.bind(this);
    }

    deleteMoney(id){
        MoneyService.deleteMoney(id).then( res => {
            this.setState({moneys: this.state.moneys.filter(money => money.moneyId !== id)});
        });
    }
    viewMoney(id){
        this.props.history.push(`/view-money/${id}`);
    }
    editMoney(id){
        this.props.history.push(`/add-money/${id}`);
    }

    componentDidMount(){
        MoneyService.getMoneys().then((res) => {
            this.setState({ moneys: res.data});
        });
    }

    addMoney(){
        this.props.history.push('/add-money/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Money List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addMoney}> Add Money</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.moneys.map(
                                        money => 
                                        <tr key = {money.moneyId}>
                                             <td> { money.multiplier } </td>
                                             <td> { money.unit } </td>
                                             <td> { money.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editMoney(money.moneyId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteMoney(money.moneyId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewMoney(money.moneyId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListMoneyComponent
