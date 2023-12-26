import React, { Component } from 'react'
import VoltageLimitService from '../services/VoltageLimitService'

class ViewVoltageLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            voltageLimit: {}
        }
    }

    componentDidMount(){
        VoltageLimitService.getVoltageLimitById(this.state.id).then( res => {
            this.setState({voltageLimit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VoltageLimit Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.voltageLimit.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVoltageLimitComponent
