import React, { Component } from 'react'
import TemperatureService from '../services/TemperatureService'

class ViewTemperatureComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            temperature: {}
        }
    }

    componentDidMount(){
        TemperatureService.getTemperatureById(this.state.id).then( res => {
            this.setState({temperature: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Temperature Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.temperature.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.temperature.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.temperature.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTemperatureComponent
