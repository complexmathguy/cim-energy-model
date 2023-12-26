import React, { Component } from 'react'
import PowerSystemStabilizerUserDefinedService from '../services/PowerSystemStabilizerUserDefinedService'

class ViewPowerSystemStabilizerUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            powerSystemStabilizerUserDefined: {}
        }
    }

    componentDidMount(){
        PowerSystemStabilizerUserDefinedService.getPowerSystemStabilizerUserDefinedById(this.state.id).then( res => {
            this.setState({powerSystemStabilizerUserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PowerSystemStabilizerUserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.powerSystemStabilizerUserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPowerSystemStabilizerUserDefinedComponent
