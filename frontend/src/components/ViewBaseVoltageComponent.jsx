import React, { Component } from 'react'
import BaseVoltageService from '../services/BaseVoltageService'

class ViewBaseVoltageComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            baseVoltage: {}
        }
    }

    componentDidMount(){
        BaseVoltageService.getBaseVoltageById(this.state.id).then( res => {
            this.setState({baseVoltage: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View BaseVoltage Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> nominalVoltage:&emsp; </label>
                            <div> { this.state.baseVoltage.nominalVoltage }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewBaseVoltageComponent
