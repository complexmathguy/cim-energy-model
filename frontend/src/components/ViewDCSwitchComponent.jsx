import React, { Component } from 'react'
import DCSwitchService from '../services/DCSwitchService'

class ViewDCSwitchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCSwitch: {}
        }
    }

    componentDidMount(){
        DCSwitchService.getDCSwitchById(this.state.id).then( res => {
            this.setState({dCSwitch: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCSwitch Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCSwitchComponent
