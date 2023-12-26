import React, { Component } from 'react'
import PhaseTapChangerService from '../services/PhaseTapChangerService'

class ViewPhaseTapChangerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            phaseTapChanger: {}
        }
    }

    componentDidMount(){
        PhaseTapChangerService.getPhaseTapChangerById(this.state.id).then( res => {
            this.setState({phaseTapChanger: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PhaseTapChanger Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPhaseTapChangerComponent
