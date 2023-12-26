import React, { Component } from 'react'
import RatioTapChangerTablePointService from '../services/RatioTapChangerTablePointService'

class ViewRatioTapChangerTablePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            ratioTapChangerTablePoint: {}
        }
    }

    componentDidMount(){
        RatioTapChangerTablePointService.getRatioTapChangerTablePointById(this.state.id).then( res => {
            this.setState({ratioTapChangerTablePoint: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RatioTapChangerTablePoint Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRatioTapChangerTablePointComponent
