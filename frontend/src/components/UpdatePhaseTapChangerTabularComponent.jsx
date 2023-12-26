import React, { Component } from 'react'
import PhaseTapChangerTabularService from '../services/PhaseTapChangerTabularService';

class UpdatePhaseTapChangerTabularComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePhaseTapChangerTabular = this.updatePhaseTapChangerTabular.bind(this);

    }

    componentDidMount(){
        PhaseTapChangerTabularService.getPhaseTapChangerTabularById(this.state.id).then( (res) =>{
            let phaseTapChangerTabular = res.data;
            this.setState({
            });
        });
    }

    updatePhaseTapChangerTabular = (e) => {
        e.preventDefault();
        let phaseTapChangerTabular = {
            phaseTapChangerTabularId: this.state.id,
        };
        console.log('phaseTapChangerTabular => ' + JSON.stringify(phaseTapChangerTabular));
        console.log('id => ' + JSON.stringify(this.state.id));
        PhaseTapChangerTabularService.updatePhaseTapChangerTabular(phaseTapChangerTabular).then( res => {
            this.props.history.push('/phaseTapChangerTabulars');
        });
    }


    cancel(){
        this.props.history.push('/phaseTapChangerTabulars');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PhaseTapChangerTabular</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePhaseTapChangerTabular}>Save</button>
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

export default UpdatePhaseTapChangerTabularComponent
