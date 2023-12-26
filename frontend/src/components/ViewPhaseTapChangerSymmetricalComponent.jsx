import React, { Component } from 'react'
import PhaseTapChangerSymmetricalService from '../services/PhaseTapChangerSymmetricalService'

class ViewPhaseTapChangerSymmetricalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            phaseTapChangerSymmetrical: {}
        }
    }

    componentDidMount(){
        PhaseTapChangerSymmetricalService.getPhaseTapChangerSymmetricalById(this.state.id).then( res => {
            this.setState({phaseTapChangerSymmetrical: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PhaseTapChangerSymmetrical Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPhaseTapChangerSymmetricalComponent
