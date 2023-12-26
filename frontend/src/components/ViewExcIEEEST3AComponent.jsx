import React, { Component } from 'react'
import ExcIEEEST3AService from '../services/ExcIEEEST3AService'

class ViewExcIEEEST3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEST3A: {}
        }
    }

    componentDidMount(){
        ExcIEEEST3AService.getExcIEEEST3AById(this.state.id).then( res => {
            this.setState({excIEEEST3A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEST3A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excIEEEST3A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excIEEEST3A.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kg:&emsp; </label>
                            <div> { this.state.excIEEEST3A.kg }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.excIEEEST3A.ki }</div>
                        </div>
                        <div className = "row">
                            <label> km:&emsp; </label>
                            <div> { this.state.excIEEEST3A.km }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.excIEEEST3A.kp }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excIEEEST3A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excIEEEST3A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excIEEEST3A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> thetap:&emsp; </label>
                            <div> { this.state.excIEEEST3A.thetap }</div>
                        </div>
                        <div className = "row">
                            <label> tm:&emsp; </label>
                            <div> { this.state.excIEEEST3A.tm }</div>
                        </div>
                        <div className = "row">
                            <label> vbmax:&emsp; </label>
                            <div> { this.state.excIEEEST3A.vbmax }</div>
                        </div>
                        <div className = "row">
                            <label> vgmax:&emsp; </label>
                            <div> { this.state.excIEEEST3A.vgmax }</div>
                        </div>
                        <div className = "row">
                            <label> vimax:&emsp; </label>
                            <div> { this.state.excIEEEST3A.vimax }</div>
                        </div>
                        <div className = "row">
                            <label> vimin:&emsp; </label>
                            <div> { this.state.excIEEEST3A.vimin }</div>
                        </div>
                        <div className = "row">
                            <label> vmmax:&emsp; </label>
                            <div> { this.state.excIEEEST3A.vmmax }</div>
                        </div>
                        <div className = "row">
                            <label> vmmin:&emsp; </label>
                            <div> { this.state.excIEEEST3A.vmmin }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excIEEEST3A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excIEEEST3A.vrmin }</div>
                        </div>
                        <div className = "row">
                            <label> xl:&emsp; </label>
                            <div> { this.state.excIEEEST3A.xl }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEST3AComponent
