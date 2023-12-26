import React, { Component } from 'react'
import StationSupplyService from '../services/StationSupplyService'

class ViewStationSupplyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            stationSupply: {}
        }
    }

    componentDidMount(){
        StationSupplyService.getStationSupplyById(this.state.id).then( res => {
            this.setState({stationSupply: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View StationSupply Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewStationSupplyComponent
