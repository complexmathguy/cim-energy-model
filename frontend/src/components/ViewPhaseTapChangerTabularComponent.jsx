import React, { Component } from 'react'
import PhaseTapChangerTabularService from '../services/PhaseTapChangerTabularService'

class ViewPhaseTapChangerTabularComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            phaseTapChangerTabular: {}
        }
    }

    componentDidMount(){
        PhaseTapChangerTabularService.getPhaseTapChangerTabularById(this.state.id).then( res => {
            this.setState({phaseTapChangerTabular: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PhaseTapChangerTabular Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPhaseTapChangerTabularComponent
