import React, { Component } from 'react'
import PhaseTapChangerLinearService from '../services/PhaseTapChangerLinearService'

class ViewPhaseTapChangerLinearComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            phaseTapChangerLinear: {}
        }
    }

    componentDidMount(){
        PhaseTapChangerLinearService.getPhaseTapChangerLinearById(this.state.id).then( res => {
            this.setState({phaseTapChangerLinear: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PhaseTapChangerLinear Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> stepPhaseShiftIncrement:&emsp; </label>
                            <div> { this.state.phaseTapChangerLinear.stepPhaseShiftIncrement }</div>
                        </div>
                        <div className = "row">
                            <label> xMax:&emsp; </label>
                            <div> { this.state.phaseTapChangerLinear.xMax }</div>
                        </div>
                        <div className = "row">
                            <label> xMin:&emsp; </label>
                            <div> { this.state.phaseTapChangerLinear.xMin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPhaseTapChangerLinearComponent
