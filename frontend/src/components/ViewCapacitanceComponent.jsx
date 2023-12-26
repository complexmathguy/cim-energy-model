import React, { Component } from 'react'
import CapacitanceService from '../services/CapacitanceService'

class ViewCapacitanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            capacitance: {}
        }
    }

    componentDidMount(){
        CapacitanceService.getCapacitanceById(this.state.id).then( res => {
            this.setState({capacitance: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Capacitance Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.capacitance.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.capacitance.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.capacitance.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewCapacitanceComponent
