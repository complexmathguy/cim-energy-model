import React, { Component } from 'react'
import SeasonService from '../services/SeasonService'

class ViewSeasonComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            season: {}
        }
    }

    componentDidMount(){
        SeasonService.getSeasonById(this.state.id).then( res => {
            this.setState({season: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Season Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> endDate:&emsp; </label>
                            <div> { this.state.season.endDate }</div>
                        </div>
                        <div className = "row">
                            <label> startDate:&emsp; </label>
                            <div> { this.state.season.startDate }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSeasonComponent
