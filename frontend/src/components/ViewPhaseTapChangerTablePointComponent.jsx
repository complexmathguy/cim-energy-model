import React, { Component } from 'react'
import PhaseTapChangerTablePointService from '../services/PhaseTapChangerTablePointService'

class ViewPhaseTapChangerTablePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            phaseTapChangerTablePoint: {}
        }
    }

    componentDidMount(){
        PhaseTapChangerTablePointService.getPhaseTapChangerTablePointById(this.state.id).then( res => {
            this.setState({phaseTapChangerTablePoint: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PhaseTapChangerTablePoint Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> angle:&emsp; </label>
                            <div> { this.state.phaseTapChangerTablePoint.angle }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPhaseTapChangerTablePointComponent
