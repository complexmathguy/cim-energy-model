import React, { Component } from 'react'
import ApparentPowerLimitService from '../services/ApparentPowerLimitService'

class ViewApparentPowerLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            apparentPowerLimit: {}
        }
    }

    componentDidMount(){
        ApparentPowerLimitService.getApparentPowerLimitById(this.state.id).then( res => {
            this.setState({apparentPowerLimit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ApparentPowerLimit Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.apparentPowerLimit.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewApparentPowerLimitComponent
