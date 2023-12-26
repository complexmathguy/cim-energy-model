import React, { Component } from 'react'
import PhaseTapChangerTableService from '../services/PhaseTapChangerTableService';

class UpdatePhaseTapChangerTableComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePhaseTapChangerTable = this.updatePhaseTapChangerTable.bind(this);

    }

    componentDidMount(){
        PhaseTapChangerTableService.getPhaseTapChangerTableById(this.state.id).then( (res) =>{
            let phaseTapChangerTable = res.data;
            this.setState({
            });
        });
    }

    updatePhaseTapChangerTable = (e) => {
        e.preventDefault();
        let phaseTapChangerTable = {
            phaseTapChangerTableId: this.state.id,
        };
        console.log('phaseTapChangerTable => ' + JSON.stringify(phaseTapChangerTable));
        console.log('id => ' + JSON.stringify(this.state.id));
        PhaseTapChangerTableService.updatePhaseTapChangerTable(phaseTapChangerTable).then( res => {
            this.props.history.push('/phaseTapChangerTables');
        });
    }


    cancel(){
        this.props.history.push('/phaseTapChangerTables');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PhaseTapChangerTable</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePhaseTapChangerTable}>Save</button>
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

export default UpdatePhaseTapChangerTableComponent
