import React, { Component } from 'react'
import EnergyConsumerService from '../services/EnergyConsumerService'

class ViewEnergyConsumerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            energyConsumer: {}
        }
    }

    componentDidMount(){
        EnergyConsumerService.getEnergyConsumerById(this.state.id).then( res => {
            this.setState({energyConsumer: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EnergyConsumer Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> pfixed:&emsp; </label>
                            <div> { this.state.energyConsumer.pfixed }</div>
                        </div>
                        <div className = "row">
                            <label> pfixedPct:&emsp; </label>
                            <div> { this.state.energyConsumer.pfixedPct }</div>
                        </div>
                        <div className = "row">
                            <label> qfixed:&emsp; </label>
                            <div> { this.state.energyConsumer.qfixed }</div>
                        </div>
                        <div className = "row">
                            <label> qfixedPct:&emsp; </label>
                            <div> { this.state.energyConsumer.qfixedPct }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEnergyConsumerComponent
