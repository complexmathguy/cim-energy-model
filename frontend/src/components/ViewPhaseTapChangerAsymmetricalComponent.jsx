import React, { Component } from 'react'
import PhaseTapChangerAsymmetricalService from '../services/PhaseTapChangerAsymmetricalService'

class ViewPhaseTapChangerAsymmetricalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            phaseTapChangerAsymmetrical: {}
        }
    }

    componentDidMount(){
        PhaseTapChangerAsymmetricalService.getPhaseTapChangerAsymmetricalById(this.state.id).then( res => {
            this.setState({phaseTapChangerAsymmetrical: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PhaseTapChangerAsymmetrical Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> windingConnectionAngle:&emsp; </label>
                            <div> { this.state.phaseTapChangerAsymmetrical.windingConnectionAngle }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPhaseTapChangerAsymmetricalComponent
