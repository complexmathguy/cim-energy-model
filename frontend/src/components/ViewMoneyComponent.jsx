import React, { Component } from 'react'
import MoneyService from '../services/MoneyService'

class ViewMoneyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            money: {}
        }
    }

    componentDidMount(){
        MoneyService.getMoneyById(this.state.id).then( res => {
            this.setState({money: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Money Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.money.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.money.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.money.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewMoneyComponent
