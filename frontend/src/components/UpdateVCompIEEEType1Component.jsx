import React, { Component } from 'react'
import VCompIEEEType1Service from '../services/VCompIEEEType1Service';

class UpdateVCompIEEEType1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                rc: '',
                tr: '',
                xc: ''
        }
        this.updateVCompIEEEType1 = this.updateVCompIEEEType1.bind(this);

        this.changercHandler = this.changercHandler.bind(this);
        this.changetrHandler = this.changetrHandler.bind(this);
        this.changexcHandler = this.changexcHandler.bind(this);
    }

    componentDidMount(){
        VCompIEEEType1Service.getVCompIEEEType1ById(this.state.id).then( (res) =>{
            let vCompIEEEType1 = res.data;
            this.setState({
                rc: vCompIEEEType1.rc,
                tr: vCompIEEEType1.tr,
                xc: vCompIEEEType1.xc
            });
        });
    }

    updateVCompIEEEType1 = (e) => {
        e.preventDefault();
        let vCompIEEEType1 = {
            vCompIEEEType1Id: this.state.id,
            rc: this.state.rc,
            tr: this.state.tr,
            xc: this.state.xc
        };
        console.log('vCompIEEEType1 => ' + JSON.stringify(vCompIEEEType1));
        console.log('id => ' + JSON.stringify(this.state.id));
        VCompIEEEType1Service.updateVCompIEEEType1(vCompIEEEType1).then( res => {
            this.props.history.push('/vCompIEEEType1s');
        });
    }

    changercHandler= (event) => {
        this.setState({rc: event.target.value});
    }
    changetrHandler= (event) => {
        this.setState({tr: event.target.value});
    }
    changexcHandler= (event) => {
        this.setState({xc: event.target.value});
    }

    cancel(){
        this.props.history.push('/vCompIEEEType1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VCompIEEEType1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> rc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tr: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xc: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVCompIEEEType1}>Save</button>
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

export default UpdateVCompIEEEType1Component
