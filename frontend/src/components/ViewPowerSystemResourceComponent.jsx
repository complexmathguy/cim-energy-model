import React, { Component } from 'react'
import PowerSystemResourceService from '../services/PowerSystemResourceService'

class ViewPowerSystemResourceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            powerSystemResource: {}
        }
    }

    componentDidMount(){
        PowerSystemResourceService.getPowerSystemResourceById(this.state.id).then( res => {
            this.setState({powerSystemResource: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PowerSystemResource Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPowerSystemResourceComponent
