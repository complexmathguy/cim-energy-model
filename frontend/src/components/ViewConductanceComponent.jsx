import React, { Component } from 'react'
import ConductanceService from '../services/ConductanceService'

class ViewConductanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            conductance: {}
        }
    }

    componentDidMount(){
        ConductanceService.getConductanceById(this.state.id).then( res => {
            this.setState({conductance: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Conductance Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.conductance.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.conductance.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.conductance.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewConductanceComponent
