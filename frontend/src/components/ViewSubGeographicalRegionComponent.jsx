import React, { Component } from 'react'
import SubGeographicalRegionService from '../services/SubGeographicalRegionService'

class ViewSubGeographicalRegionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            subGeographicalRegion: {}
        }
    }

    componentDidMount(){
        SubGeographicalRegionService.getSubGeographicalRegionById(this.state.id).then( res => {
            this.setState({subGeographicalRegion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SubGeographicalRegion Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSubGeographicalRegionComponent
