import React, { Component } from 'react'
import GeographicalRegionService from '../services/GeographicalRegionService'

class ViewGeographicalRegionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            geographicalRegion: {}
        }
    }

    componentDidMount(){
        GeographicalRegionService.getGeographicalRegionById(this.state.id).then( res => {
            this.setState({geographicalRegion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GeographicalRegion Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGeographicalRegionComponent
