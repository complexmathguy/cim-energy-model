import React, { Component } from 'react'
import WindTurbineType4bIECService from '../services/WindTurbineType4bIECService'

class ViewWindTurbineType4bIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windTurbineType4bIEC: {}
        }
    }

    componentDidMount(){
        WindTurbineType4bIECService.getWindTurbineType4bIECById(this.state.id).then( res => {
            this.setState({windTurbineType4bIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindTurbineType4bIEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindTurbineType4bIECComponent
