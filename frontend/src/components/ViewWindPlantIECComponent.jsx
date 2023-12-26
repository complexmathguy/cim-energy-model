import React, { Component } from 'react'
import WindPlantIECService from '../services/WindPlantIECService'

class ViewWindPlantIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windPlantIEC: {}
        }
    }

    componentDidMount(){
        WindPlantIECService.getWindPlantIECById(this.state.id).then( res => {
            this.setState({windPlantIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindPlantIEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindPlantIECComponent
