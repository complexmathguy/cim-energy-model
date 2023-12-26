import React, { Component } from 'react'
import LocationService from '../services/LocationService'

class ViewLocationComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            location: {}
        }
    }

    componentDidMount(){
        LocationService.getLocationById(this.state.id).then( res => {
            this.setState({location: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Location Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLocationComponent
