import React, { Component } from 'react'
import PhaseTapChangerSymmetricalService from '../services/PhaseTapChangerSymmetricalService';

class UpdatePhaseTapChangerSymmetricalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePhaseTapChangerSymmetrical = this.updatePhaseTapChangerSymmetrical.bind(this);

    }

    componentDidMount(){
        PhaseTapChangerSymmetricalService.getPhaseTapChangerSymmetricalById(this.state.id).then( (res) =>{
            let phaseTapChangerSymmetrical = res.data;
            this.setState({
            });
        });
    }

    updatePhaseTapChangerSymmetrical = (e) => {
        e.preventDefault();
        let phaseTapChangerSymmetrical = {
            phaseTapChangerSymmetricalId: this.state.id,
        };
        console.log('phaseTapChangerSymmetrical => ' + JSON.stringify(phaseTapChangerSymmetrical));
        console.log('id => ' + JSON.stringify(this.state.id));
        PhaseTapChangerSymmetricalService.updatePhaseTapChangerSymmetrical(phaseTapChangerSymmetrical).then( res => {
            this.props.history.push('/phaseTapChangerSymmetricals');
        });
    }


    cancel(){
        this.props.history.push('/phaseTapChangerSymmetricals');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PhaseTapChangerSymmetrical</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePhaseTapChangerSymmetrical}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdatePhaseTapChangerSymmetricalComponent
