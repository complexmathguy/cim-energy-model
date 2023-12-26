import React, { Component } from 'react'
import WindPitchContEmulIECService from '../services/WindPitchContEmulIECService'

class ViewWindPitchContEmulIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windPitchContEmulIEC: {}
        }
    }

    componentDidMount(){
        WindPitchContEmulIECService.getWindPitchContEmulIECById(this.state.id).then( res => {
            this.setState({windPitchContEmulIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindPitchContEmulIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> kdroop:&emsp; </label>
                            <div> { this.state.windPitchContEmulIEC.kdroop }</div>
                        </div>
                        <div className = "row">
                            <label> kipce:&emsp; </label>
                            <div> { this.state.windPitchContEmulIEC.kipce }</div>
                        </div>
                        <div className = "row">
                            <label> komegaaero:&emsp; </label>
                            <div> { this.state.windPitchContEmulIEC.komegaaero }</div>
                        </div>
                        <div className = "row">
                            <label> kppce:&emsp; </label>
                            <div> { this.state.windPitchContEmulIEC.kppce }</div>
                        </div>
                        <div className = "row">
                            <label> omegaref:&emsp; </label>
                            <div> { this.state.windPitchContEmulIEC.omegaref }</div>
                        </div>
                        <div className = "row">
                            <label> pimax:&emsp; </label>
                            <div> { this.state.windPitchContEmulIEC.pimax }</div>
                        </div>
                        <div className = "row">
                            <label> pimin:&emsp; </label>
                            <div> { this.state.windPitchContEmulIEC.pimin }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.windPitchContEmulIEC.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.windPitchContEmulIEC.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> tpe:&emsp; </label>
                            <div> { this.state.windPitchContEmulIEC.tpe }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindPitchContEmulIECComponent
