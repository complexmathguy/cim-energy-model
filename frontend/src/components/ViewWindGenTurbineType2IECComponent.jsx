import React, { Component } from 'react'
import WindGenTurbineType2IECService from '../services/WindGenTurbineType2IECService'

class ViewWindGenTurbineType2IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windGenTurbineType2IEC: {}
        }
    }

    componentDidMount(){
        WindGenTurbineType2IECService.getWindGenTurbineType2IECById(this.state.id).then( res => {
            this.setState({windGenTurbineType2IEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindGenTurbineType2IEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindGenTurbineType2IECComponent
