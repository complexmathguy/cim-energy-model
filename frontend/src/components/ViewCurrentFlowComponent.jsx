import React, { Component } from 'react'
import CurrentFlowService from '../services/CurrentFlowService'

class ViewCurrentFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            currentFlow: {}
        }
    }

    componentDidMount(){
        CurrentFlowService.getCurrentFlowById(this.state.id).then( res => {
            this.setState({currentFlow: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View CurrentFlow Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.currentFlow.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.currentFlow.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.currentFlow.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewCurrentFlowComponent
