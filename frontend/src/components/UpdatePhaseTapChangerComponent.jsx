import React, { Component } from 'react'
import PhaseTapChangerService from '../services/PhaseTapChangerService';

class UpdatePhaseTapChangerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePhaseTapChanger = this.updatePhaseTapChanger.bind(this);

    }

    componentDidMount(){
        PhaseTapChangerService.getPhaseTapChangerById(this.state.id).then( (res) =>{
            let phaseTapChanger = res.data;
            this.setState({
            });
        });
    }

    updatePhaseTapChanger = (e) => {
        e.preventDefault();
        let phaseTapChanger = {
            phaseTapChangerId: this.state.id,
        };
        console.log('phaseTapChanger => ' + JSON.stringify(phaseTapChanger));
        console.log('id => ' + JSON.stringify(this.state.id));
        PhaseTapChangerService.updatePhaseTapChanger(phaseTapChanger).then( res => {
            this.props.history.push('/phaseTapChangers');
        });
    }


    cancel(){
        this.props.history.push('/phaseTapChangers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PhaseTapChanger</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePhaseTapChanger}>Save</button>
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

export default UpdatePhaseTapChangerComponent
