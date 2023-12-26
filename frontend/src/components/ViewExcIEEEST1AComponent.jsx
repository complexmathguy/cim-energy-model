import React, { Component } from 'react'
import ExcIEEEST1AService from '../services/ExcIEEEST1AService'

class ViewExcIEEEST1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEST1A: {}
        }
    }

    componentDidMount(){
        ExcIEEEST1AService.getExcIEEEST1AById(this.state.id).then( res => {
            this.setState({excIEEEST1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEST1A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ilr:&emsp; </label>
                            <div> { this.state.excIEEEST1A.ilr }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excIEEEST1A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excIEEEST1A.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excIEEEST1A.kf }</div>
                        </div>
                        <div className = "row">
                            <label> klr:&emsp; </label>
                            <div> { this.state.excIEEEST1A.klr }</div>
                        </div>
                        <div className = "row">
                            <label> pssin:&emsp; </label>
                            <div> { this.state.excIEEEST1A.pssin }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excIEEEST1A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excIEEEST1A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tb1:&emsp; </label>
                            <div> { this.state.excIEEEST1A.tb1 }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excIEEEST1A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> tc1:&emsp; </label>
                            <div> { this.state.excIEEEST1A.tc1 }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excIEEEST1A.tf }</div>
                        </div>
                        <div className = "row">
                            <label> uelin:&emsp; </label>
                            <div> { this.state.excIEEEST1A.uelin }</div>
                        </div>
                        <div className = "row">
                            <label> vamax:&emsp; </label>
                            <div> { this.state.excIEEEST1A.vamax }</div>
                        </div>
                        <div className = "row">
                            <label> vamin:&emsp; </label>
                            <div> { this.state.excIEEEST1A.vamin }</div>
                        </div>
                        <div className = "row">
                            <label> vimax:&emsp; </label>
                            <div> { this.state.excIEEEST1A.vimax }</div>
                        </div>
                        <div className = "row">
                            <label> vimin:&emsp; </label>
                            <div> { this.state.excIEEEST1A.vimin }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excIEEEST1A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excIEEEST1A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEST1AComponent
