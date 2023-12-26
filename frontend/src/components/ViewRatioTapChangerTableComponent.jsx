import React, { Component } from 'react'
import RatioTapChangerTableService from '../services/RatioTapChangerTableService'

class ViewRatioTapChangerTableComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            ratioTapChangerTable: {}
        }
    }

    componentDidMount(){
        RatioTapChangerTableService.getRatioTapChangerTableById(this.state.id).then( res => {
            this.setState({ratioTapChangerTable: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RatioTapChangerTable Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRatioTapChangerTableComponent
