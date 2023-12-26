import React, { Component } from 'react'
import FrequencyService from '../services/FrequencyService'

class ViewFrequencyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            frequency: {}
        }
    }

    componentDidMount(){
        FrequencyService.getFrequencyById(this.state.id).then( res => {
            this.setState({frequency: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Frequency Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.frequency.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.frequency.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.frequency.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewFrequencyComponent
