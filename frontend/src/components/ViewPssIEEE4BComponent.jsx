import React, { Component } from 'react'
import PssIEEE4BService from '../services/PssIEEE4BService'

class ViewPssIEEE4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssIEEE4B: {}
        }
    }

    componentDidMount(){
        PssIEEE4BService.getPssIEEE4BById(this.state.id).then( res => {
            this.setState({pssIEEE4B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssIEEE4B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> bwh1:&emsp; </label>
                            <div> { this.state.pssIEEE4B.bwh1 }</div>
                        </div>
                        <div className = "row">
                            <label> bwh2:&emsp; </label>
                            <div> { this.state.pssIEEE4B.bwh2 }</div>
                        </div>
                        <div className = "row">
                            <label> bwl1:&emsp; </label>
                            <div> { this.state.pssIEEE4B.bwl1 }</div>
                        </div>
                        <div className = "row">
                            <label> bwl2:&emsp; </label>
                            <div> { this.state.pssIEEE4B.bwl2 }</div>
                        </div>
                        <div className = "row">
                            <label> kh:&emsp; </label>
                            <div> { this.state.pssIEEE4B.kh }</div>
                        </div>
                        <div className = "row">
                            <label> kh1:&emsp; </label>
                            <div> { this.state.pssIEEE4B.kh1 }</div>
                        </div>
                        <div className = "row">
                            <label> kh11:&emsp; </label>
                            <div> { this.state.pssIEEE4B.kh11 }</div>
                        </div>
                        <div className = "row">
                            <label> kh17:&emsp; </label>
                            <div> { this.state.pssIEEE4B.kh17 }</div>
                        </div>
                        <div className = "row">
                            <label> kh2:&emsp; </label>
                            <div> { this.state.pssIEEE4B.kh2 }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ki }</div>
                        </div>
                        <div className = "row">
                            <label> ki1:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ki1 }</div>
                        </div>
                        <div className = "row">
                            <label> ki11:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ki11 }</div>
                        </div>
                        <div className = "row">
                            <label> ki17:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ki17 }</div>
                        </div>
                        <div className = "row">
                            <label> ki2:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ki2 }</div>
                        </div>
                        <div className = "row">
                            <label> kl:&emsp; </label>
                            <div> { this.state.pssIEEE4B.kl }</div>
                        </div>
                        <div className = "row">
                            <label> kl1:&emsp; </label>
                            <div> { this.state.pssIEEE4B.kl1 }</div>
                        </div>
                        <div className = "row">
                            <label> kl11:&emsp; </label>
                            <div> { this.state.pssIEEE4B.kl11 }</div>
                        </div>
                        <div className = "row">
                            <label> kl17:&emsp; </label>
                            <div> { this.state.pssIEEE4B.kl17 }</div>
                        </div>
                        <div className = "row">
                            <label> kl2:&emsp; </label>
                            <div> { this.state.pssIEEE4B.kl2 }</div>
                        </div>
                        <div className = "row">
                            <label> omeganh1:&emsp; </label>
                            <div> { this.state.pssIEEE4B.omeganh1 }</div>
                        </div>
                        <div className = "row">
                            <label> omeganh2:&emsp; </label>
                            <div> { this.state.pssIEEE4B.omeganh2 }</div>
                        </div>
                        <div className = "row">
                            <label> omeganl1:&emsp; </label>
                            <div> { this.state.pssIEEE4B.omeganl1 }</div>
                        </div>
                        <div className = "row">
                            <label> omeganl2:&emsp; </label>
                            <div> { this.state.pssIEEE4B.omeganl2 }</div>
                        </div>
                        <div className = "row">
                            <label> th1:&emsp; </label>
                            <div> { this.state.pssIEEE4B.th1 }</div>
                        </div>
                        <div className = "row">
                            <label> th10:&emsp; </label>
                            <div> { this.state.pssIEEE4B.th10 }</div>
                        </div>
                        <div className = "row">
                            <label> th11:&emsp; </label>
                            <div> { this.state.pssIEEE4B.th11 }</div>
                        </div>
                        <div className = "row">
                            <label> th12:&emsp; </label>
                            <div> { this.state.pssIEEE4B.th12 }</div>
                        </div>
                        <div className = "row">
                            <label> th2:&emsp; </label>
                            <div> { this.state.pssIEEE4B.th2 }</div>
                        </div>
                        <div className = "row">
                            <label> th3:&emsp; </label>
                            <div> { this.state.pssIEEE4B.th3 }</div>
                        </div>
                        <div className = "row">
                            <label> th4:&emsp; </label>
                            <div> { this.state.pssIEEE4B.th4 }</div>
                        </div>
                        <div className = "row">
                            <label> th5:&emsp; </label>
                            <div> { this.state.pssIEEE4B.th5 }</div>
                        </div>
                        <div className = "row">
                            <label> th6:&emsp; </label>
                            <div> { this.state.pssIEEE4B.th6 }</div>
                        </div>
                        <div className = "row">
                            <label> th7:&emsp; </label>
                            <div> { this.state.pssIEEE4B.th7 }</div>
                        </div>
                        <div className = "row">
                            <label> th8:&emsp; </label>
                            <div> { this.state.pssIEEE4B.th8 }</div>
                        </div>
                        <div className = "row">
                            <label> th9:&emsp; </label>
                            <div> { this.state.pssIEEE4B.th9 }</div>
                        </div>
                        <div className = "row">
                            <label> ti1:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ti1 }</div>
                        </div>
                        <div className = "row">
                            <label> ti10:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ti10 }</div>
                        </div>
                        <div className = "row">
                            <label> ti11:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ti11 }</div>
                        </div>
                        <div className = "row">
                            <label> ti12:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ti12 }</div>
                        </div>
                        <div className = "row">
                            <label> ti2:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ti2 }</div>
                        </div>
                        <div className = "row">
                            <label> ti3:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ti3 }</div>
                        </div>
                        <div className = "row">
                            <label> ti4:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ti4 }</div>
                        </div>
                        <div className = "row">
                            <label> ti5:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ti5 }</div>
                        </div>
                        <div className = "row">
                            <label> ti6:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ti6 }</div>
                        </div>
                        <div className = "row">
                            <label> ti7:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ti7 }</div>
                        </div>
                        <div className = "row">
                            <label> ti8:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ti8 }</div>
                        </div>
                        <div className = "row">
                            <label> ti9:&emsp; </label>
                            <div> { this.state.pssIEEE4B.ti9 }</div>
                        </div>
                        <div className = "row">
                            <label> tl1:&emsp; </label>
                            <div> { this.state.pssIEEE4B.tl1 }</div>
                        </div>
                        <div className = "row">
                            <label> tl10:&emsp; </label>
                            <div> { this.state.pssIEEE4B.tl10 }</div>
                        </div>
                        <div className = "row">
                            <label> tl11:&emsp; </label>
                            <div> { this.state.pssIEEE4B.tl11 }</div>
                        </div>
                        <div className = "row">
                            <label> tl12:&emsp; </label>
                            <div> { this.state.pssIEEE4B.tl12 }</div>
                        </div>
                        <div className = "row">
                            <label> tl2:&emsp; </label>
                            <div> { this.state.pssIEEE4B.tl2 }</div>
                        </div>
                        <div className = "row">
                            <label> tl3:&emsp; </label>
                            <div> { this.state.pssIEEE4B.tl3 }</div>
                        </div>
                        <div className = "row">
                            <label> tl4:&emsp; </label>
                            <div> { this.state.pssIEEE4B.tl4 }</div>
                        </div>
                        <div className = "row">
                            <label> tl5:&emsp; </label>
                            <div> { this.state.pssIEEE4B.tl5 }</div>
                        </div>
                        <div className = "row">
                            <label> tl6:&emsp; </label>
                            <div> { this.state.pssIEEE4B.tl6 }</div>
                        </div>
                        <div className = "row">
                            <label> tl7:&emsp; </label>
                            <div> { this.state.pssIEEE4B.tl7 }</div>
                        </div>
                        <div className = "row">
                            <label> tl8:&emsp; </label>
                            <div> { this.state.pssIEEE4B.tl8 }</div>
                        </div>
                        <div className = "row">
                            <label> tl9:&emsp; </label>
                            <div> { this.state.pssIEEE4B.tl9 }</div>
                        </div>
                        <div className = "row">
                            <label> vhmax:&emsp; </label>
                            <div> { this.state.pssIEEE4B.vhmax }</div>
                        </div>
                        <div className = "row">
                            <label> vhmin:&emsp; </label>
                            <div> { this.state.pssIEEE4B.vhmin }</div>
                        </div>
                        <div className = "row">
                            <label> vimax:&emsp; </label>
                            <div> { this.state.pssIEEE4B.vimax }</div>
                        </div>
                        <div className = "row">
                            <label> vimin:&emsp; </label>
                            <div> { this.state.pssIEEE4B.vimin }</div>
                        </div>
                        <div className = "row">
                            <label> vlmax:&emsp; </label>
                            <div> { this.state.pssIEEE4B.vlmax }</div>
                        </div>
                        <div className = "row">
                            <label> vlmin:&emsp; </label>
                            <div> { this.state.pssIEEE4B.vlmin }</div>
                        </div>
                        <div className = "row">
                            <label> vstmax:&emsp; </label>
                            <div> { this.state.pssIEEE4B.vstmax }</div>
                        </div>
                        <div className = "row">
                            <label> vstmin:&emsp; </label>
                            <div> { this.state.pssIEEE4B.vstmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssIEEE4BComponent
