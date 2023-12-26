import React, { Component } from 'react'
import WindPlantUserDefinedService from '../services/WindPlantUserDefinedService'

class ViewWindPlantUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windPlantUserDefined: {}
        }
    }

    componentDidMount(){
        WindPlantUserDefinedService.getWindPlantUserDefinedById(this.state.id).then( res => {
            this.setState({windPlantUserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindPlantUserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.windPlantUserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindPlantUserDefinedComponent
